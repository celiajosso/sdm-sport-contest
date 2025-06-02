package org.example.composite;

import org.example.Match;
import org.example.contestant.Contestant;

public interface MatchComponent {
    public Contestant execute();

    public Match getMatch();
}
