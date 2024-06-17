package com.tc.afd;

import java.util.*;

public class DFA {
    private State initialState;
    private Set<State> states;
    private Set<Character> alphabet;
    private Set<State> finalStates;
    public Map<State, Map<Character, State>> transitionFunction;
    private State currentState;

    public DFA(State initialState, Set<State> states, Set<Character> alphabet, Set<State> finalStates) {
        this.initialState = initialState;
        this.states = states;
        this.alphabet = alphabet;
        this.finalStates = finalStates;
        this.transitionFunction = new HashMap<>();
        for (State state : states) {
            transitionFunction.put(state, new HashMap<>());
        }
        this.currentState = initialState;
    }

    public void addTransition(State fromState, char symbol, State toState) {
        if (!states.contains(fromState) || !states.contains(toState) || !alphabet.contains(symbol)) {
            throw new IllegalArgumentException("Invalid transition");
        }
        transitionFunction.get(fromState).put(symbol, toState);
    }

    public State getInitialState() {
        return initialState;
    }

    public Set<State> getStates() {
        return states;
    }

    public Set<Character> getAlphabet() {
        return alphabet;
    }

    public Set<State> getFinalStates() {
        return finalStates;
    }

    public State getNextState(State currentState, char symbol) {
        return transitionFunction.get(currentState).get(symbol);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void chageState(char symbol) {
        if (!alphabet.contains(symbol)) {
            throw new IllegalArgumentException("Invalid transition");
        }
        this.currentState = getNextState(this.currentState, symbol);
    }

    public void reset() {
        this.currentState = this.initialState;
    }

    public boolean isFinal() {
        return finalStates.contains(currentState);
    }

    public boolean accepts(String input) {
        State currentState = initialState;
        for (char symbol : input.toCharArray()) {
            currentState = getNextState(currentState, symbol);
            if (currentState == null) {
                return false;
            }
        }
        return finalStates.contains(currentState);
    }
}
