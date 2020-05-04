package com.project.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;
/*
stack data structure to track game states
 */
public class GameStateManager {

    private Stack<State> states;
    /*
    constructs gamestate manager
     */
    public GameStateManager() {
        states = new Stack<State>();
    }
    /*
    pushes a new state onto the stack
     */
    public void push(State state) {
        states.push(state);
    }
    /*
    removes the topmost state
     */
    public void pop() {
        states.pop();
    }
    /*
    removes the topmost state and replaces it with the param

    @param state new state
     */
    public void set(State state) {
        states.pop();
        states.push(state);
    }
    /*
    updates the topmost state

    @param dt time that has passed between frames
     */
    public void update(float dt) {
        states.peek().update(dt);
    }
    /*
    renders the current state

    @param batch the batch to use for drawing
     */
    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }
    /*
    frees the memory allocated by the entire stack
     */
    public void dispose() {
        while (!states.isEmpty()) {
            states.pop().dispose();
        }
    }
    /*
    returns the topmost state

    @return current state
     */
    public State peek() {
        return states.peek();
    }
}
