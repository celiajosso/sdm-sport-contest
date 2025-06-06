package org.example.config;

import org.example.contestant.Team;
import org.example.contestant.TeamMember;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FootballTeamDataLoader {

    public static List<Team> loadTeams(String filepath) {
        List<Team> teams = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            JSONArray teamArray = (JSONArray) parser.parse(new FileReader(filepath));

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
