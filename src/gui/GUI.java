package gui;

import gui.overview.OverviewPanel;
import gui.profile.ProfilePanel;
import gui.settings.SettingsPanel;
import gui.single_input.SingleInputPanel;

import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;

    private JPanel currentlyDisplayed;

    public GUI() {
        frame = new JFrame("Notenplaner 12G9");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        //setup nav bar
        JPanel navBar = new JPanel(new BorderLayout());

        JPanel leftNavBar = new JPanel();
        leftNavBar.setLayout(new BoxLayout(leftNavBar, BoxLayout.X_AXIS));
        JButton overviewButton = new JButton("Überblick");
        overviewButton.addActionListener(_ -> switchToOverview());
        leftNavBar.add(overviewButton);
        JButton singleInputButton = new JButton("Noten eingeben");
        singleInputButton.addActionListener( _ -> switchToSingleInput());
        leftNavBar.add(singleInputButton);
        navBar.add(leftNavBar, BorderLayout.WEST);

        JPanel rightNavBar = new JPanel();
        rightNavBar.setLayout(new BoxLayout(rightNavBar, BoxLayout.X_AXIS));
        JButton profileButton = new JButton("Profil");
        profileButton.addActionListener(_ -> switchToProfile());
        rightNavBar.add(profileButton);
        JButton settingsButton = new JButton("Einstellungen");
        settingsButton.addActionListener(_ -> switchToSettings());
        rightNavBar.add(settingsButton);
        navBar.add(rightNavBar, BorderLayout.EAST);

        frame.add(navBar, BorderLayout.NORTH);




        frame.setVisible(true);
    }


    private void switchToOverview() {
        System.out.println("switch main view to overview");
        switchMainView(new OverviewPanel());
    }

    private void switchToSingleInput() {
        System.out.println("switch main view to single input");
        switchMainView(new SingleInputPanel());
    }

    private void switchToSettings() {
        System.out.println("switch main view to settings");
        switchMainView(new SettingsPanel());
    }

    private void switchToProfile() {
        System.out.println("switch main view to profile");
        switchMainView(new ProfilePanel());
    }

    private void switchMainView(JPanel view) {
        if(currentlyDisplayed != null) frame.remove(currentlyDisplayed);
        frame.add(view, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
        currentlyDisplayed = view;
    }

}
