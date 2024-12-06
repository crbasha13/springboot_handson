package Model;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="student")
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int rollNo;
    public String name;
    public int english;
    public int hindi;
    public int maths;
    public int science;
    public int social;
    public boolean marksUpdated;

    public int getTotalMarks(){
        return english+hindi+maths+science+social;
    }

    public boolean isMarksUpdated() {
        return marksUpdated;
    }

    public void setMarksUpdated(boolean marksUpdated) {
        this.marksUpdated = marksUpdated;
    }

    public Student() {
    }

    public Student(int rollNo, String name, int english, int hindi, int maths, int science, int social) {
        this.rollNo = rollNo;
        this.name = name;
        this.english = english;
        this.hindi = hindi;
        this.maths = maths;
        this.science = science;
        this.social = social;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getHindi() {
        return hindi;
    }

    public void setHindi(int hindi) {
        this.hindi = hindi;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", english=" + english +
                ", hindi=" + hindi +
                ", maths=" + maths +
                ", science=" + science +
                ", social=" + social +
                '}';
    }
}
