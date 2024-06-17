package com.tc.afd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Maquina {
    
    public State O = new State("O");
    public State C0 = new State("C0");
    public State C1 = new State("C1");
    public State C2 = new State("C2");
    public State C5 = new State("C3");
    public State B0 = new State("B0");
    public State B1 = new State("B1");
    public State B2 = new State("B2");
    public State B3 = new State("B3");
    public State B5 = new State("B3");
    public State B6 = new State("B6");
    public State A0 = new State("A0");
    public State A1 = new State("A1");
    public State A2 = new State("A2");
    public State A3 = new State("A3");
    public State A4 = new State("A4");
    public State A5 = new State("A3");
    public State A6 = new State("A6");
    public State A7 = new State("A7"); 
    public Set<State> states;
    public DFA dfa;

    public Maquina() {
        this.dfa = get_maquina();
    }

    private void addTransition(State staticstate) {
        this.dfa.addTransition(staticstate, 'A', staticstate);
        this.dfa.addTransition(staticstate, 'B', staticstate);
        this.dfa.addTransition(staticstate, 'C', staticstate);
        this.dfa.addTransition(staticstate, 'D', staticstate);
        this.dfa.addTransition(staticstate, 'E', staticstate);
        this.dfa.addTransition(staticstate, 'F', staticstate);
        this.dfa.addTransition(staticstate, 'G', staticstate);
        this.dfa.addTransition(staticstate, 'H', staticstate);
        this.dfa.addTransition(staticstate, 'I', staticstate);
    }

    private void addTransitionm(State staticstate) {
        this.dfa.addTransition(staticstate, '1', staticstate);
        this.dfa.addTransition(staticstate, '2', staticstate);
        this.dfa.addTransition(staticstate, '5', staticstate);
        this.addTransition(staticstate);
    }
    
    public DFA get_maquina() {

        this.states = new HashSet<>(Arrays.asList(this.O, this.C0, this.C1, this.C2, this.C5, this.B0, this.B1, this.B2, this.B3, this.B5, this.B6, this.A0, this.A1, this.A2, this.A3, this.A4, this.A5, this.A6, this.A7));
        Set<Character> alphabet = new HashSet<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', '1', '2', '5'));
        Set<State> finalStates = new HashSet<>(Arrays.asList(this.C1, this.C2, this.C5, this.B2, this.B3, this.B5, this.B6, this.A3, this.A4, this.A5, this.A6, this.A7));

        this.dfa = new DFA(O, this.states, alphabet, finalStates);

        this.dfa.addTransition(O, 'A', A0);
        this.dfa.addTransition(O, 'B', A0);
        this.dfa.addTransition(O, 'C', A0);

        this.dfa.addTransition(O, 'D', B0);
        this.dfa.addTransition(O, 'E', B0);
        this.dfa.addTransition(O, 'F', B0);

        this.dfa.addTransition(O, 'G', C0);
        this.dfa.addTransition(O, 'H', C0);
        this.dfa.addTransition(O, 'I', C0);

        this.dfa.addTransition(O, '1', O);
        this.dfa.addTransition(O, '2', O);
        this.dfa.addTransition(O, '5', O);

        this.dfa.addTransition(A0, '1', A1);
        this.dfa.addTransition(A0, '2', A2);
        this.dfa.addTransition(A0, '5', A5);
        this.addTransition(A0);

        this.dfa.addTransition(A1, '1', A2);
        this.dfa.addTransition(A1, '2', A3);
        this.dfa.addTransition(A1, '5', A6);
        this.addTransition(A1);

        this.dfa.addTransition(A2, '1', A3);
        this.dfa.addTransition(A2, '2', A4);
        this.dfa.addTransition(A2, '5', A7);

        this.addTransitionm(A3);
        this.addTransitionm(A4);
        this.addTransitionm(A5);
        this.addTransitionm(A6);
        this.addTransitionm(A7);

        this.dfa.addTransition(B0, '1', B1);
        this.dfa.addTransition(B0, '2', B2);
        this.dfa.addTransition(B0, '5', B5);

        this.addTransition(B0);

        this.dfa.addTransition(B1, '1', B2);
        this.dfa.addTransition(B1, '2', B3);
        this.dfa.addTransition(B1, '5', B6);
        this.addTransition(B1);

        this.addTransitionm(B2);
        this.addTransitionm(B3);
        this.addTransitionm(B5);
        this.addTransitionm(B6);
        

        this.dfa.addTransition(C0, '1', C1);
        this.dfa.addTransition(C0, '2', C2);
        this.dfa.addTransition(C0, '5', C5);
        this.addTransition(C0);

        this.addTransitionm(C1);
        this.addTransitionm(C2);
        this.addTransitionm(C5);

        return dfa;
    }
}
