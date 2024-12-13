package model;

public class Channel {
    private String name;

    public Channel(String online) {
    }

    // Constructor, getters, setters, etc.
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        // Implement equality check (important for matching channels)
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Channel channel = (Channel) obj;
        return name.equals(channel.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

