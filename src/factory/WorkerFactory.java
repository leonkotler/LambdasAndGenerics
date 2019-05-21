package factory;

import java.util.HashMap;

public class WorkerFactory {

    private HashMap<String, Creator> workersCreators;

    private interface Creator {
        Worker create();
    }

    public WorkerFactory() {
        workersCreators = new HashMap<>();

        workersCreators.put("Lecturer", () -> new Lecturer());
        workersCreators.put("Student", () -> new Student());

    }

    public Worker createWorker(String type) {

        Creator c = workersCreators.get(type);// takes O(1) time!

        if (c != null)
            return c.create();
        return null;
    }
}
