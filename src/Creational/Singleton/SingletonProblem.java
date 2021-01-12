package Creational.Singleton;

public class SingletonProblem {
    public static void main(String[] args) {
        System.out.println(Preferences.globalPreferences.getPreferences());

        Preferences secondPreference = new Preferences("Second pref");

        Preferences.globalPreferences = secondPreference;
        System.out.println(Preferences.globalPreferences.getPreferences());
    }
}

class Preferences{

    public static Preferences globalPreferences = new Preferences("First one created");

    private String preferences;

    public Preferences(String preferences) {
        this.preferences = preferences;
    }

    public String getPreferences(){
        return preferences;
    }
}
