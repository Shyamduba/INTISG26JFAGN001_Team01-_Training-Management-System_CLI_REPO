package org.cognizant.TrainingManagementSystem.Entity;

public class Course {
    private int id;
    private String title;
    private int trainerId;

    public Course(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public Course(int id, String title, int trainerId){
        this.id = id;
        this.title = title;
        this.trainerId = trainerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
