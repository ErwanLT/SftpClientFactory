package fr.eletutour.model;

public class SftpProperties {
    private String remoteHost;
    private String username;
    private String password;
    private int maxConnexionAttempt;
    private long timeBetweenConnexionAttempt;

    public SftpProperties() {
    }

    public SftpProperties(String remoteHost, String username, String password, int maxConnexionAttempt, long timeBetweenConnexionAttempt) {
        this.remoteHost = remoteHost;
        this.username = username;
        this.password = password;
        this.maxConnexionAttempt = maxConnexionAttempt;
        this.timeBetweenConnexionAttempt = timeBetweenConnexionAttempt;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxConnexionAttempt() {
        return maxConnexionAttempt;
    }

    public void setMaxConnexionAttempt(int maxConnexionAttempt) {
        this.maxConnexionAttempt = maxConnexionAttempt;
    }

    public long getTimeBetweenConnexionAttempt() {
        return timeBetweenConnexionAttempt;
    }

    public void setTimeBetweenConnexionAttempt(long timeBetweenConnexionAttempt) {
        this.timeBetweenConnexionAttempt = timeBetweenConnexionAttempt;
    }

    @Override
    public String toString() {
        return "SftpProperties{" +
                "remoteHost='" + remoteHost + '\'' +
                ", username='" + username + '\'' +
                ", maxConnexionAttempt=" + maxConnexionAttempt +
                ", timeBetweenConnexionAttempt=" + timeBetweenConnexionAttempt +
                '}';
    }
}
