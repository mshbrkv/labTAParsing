package xml_parsing;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private String empId;
    private String lastName;
    private String firstName;
    private String birthDate;
    private String position;
    private List<String> skills;
    private String managerId;
//    public void addSkill(String skill) {
//        skills.add(skill);
//    }

}
