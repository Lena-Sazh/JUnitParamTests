package com.sazhina.domain;

public enum MenuItem {

    DEV_TOOLS("Developer Tools"),
    TEAM_TOOLS("Team Tools"),
    LEARNING_TOOLS("Learning Tools"),
    SOLUTIONS("Solutions"),
    STORE("Store");

    private final String tabName;

    MenuItem(String label) {
        this.tabName = label;
    }

    public String getTabName() {
        return tabName;
    }
}
