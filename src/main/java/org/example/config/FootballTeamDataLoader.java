package org.example.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.example.contestant.Team;
import org.example.contestant.TeamMember;

public class FootballTeamDataLoader {

    public static List<Team> loadTeams(String resourceName) {
        List<Team> teams = new ArrayList<>();

        try {
            ClassLoader classLoader = FootballTeamDataLoader.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(resourceName);

            if (inputStream == null) {
                throw new RuntimeException("Resource not found: " + resourceName);
            }

            JSONParser parser = new JSONParser();
            JSONArray teamArray = (JSONArray) parser.parse(new InputStreamReader(inputStream));

            for (Object o : teamArray) {
                JSONObject teamJson = (JSONObject) o;

                String name = (String) teamJson.get("name");

                TeamMember leader = null;

                JSONArray playersJson = (JSONArray) teamJson.get("players");
                List<TeamMember> players = new ArrayList<>();

                for (Object p : playersJson) {
                    JSONObject playerJson = (JSONObject) p;
                    TeamMember player = parsePlayer(playerJson);
                    players.add(player);

                    Object isLeaderObj = playerJson.get("isLeader");
                    if (isLeaderObj != null && isLeaderObj.toString().equalsIgnoreCase("true")) {
                        leader = player;
                    }
                }

                Team team = new Team(name, leader, players.toArray(new TeamMember[0]));
                teams.add(team);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return teams;
    }

    private static TeamMember parsePlayer(JSONObject json) {
        String firstName = (String) json.get("firstName");
        String lastName = (String) json.get("lastName");
        String birthDate = (String) json.get("birthDate");
        String position = (String) json.get("role");

        return new TeamMember(firstName, lastName, birthDate, position);
    }
}
