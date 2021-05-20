package configuration;

public enum Environment {
    PROD("https://grinfer.com"),
    TEST("https://test.grinfer.com");

    private String url;

    Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
