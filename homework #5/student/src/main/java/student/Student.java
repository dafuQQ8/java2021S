/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package student;

import java.util.Objects;
/**
 * This class overrides hashCode() and equals() methods.
 *
 * @version 1.0 9 Sep 2021
 * @author kagu-tsuchi
 */
public class Student {
    String studentsName;
    String studentSurname;
	int studentsAge;
    String studentsGroup;

	Student(String name, String surname, int age, String group){
		this.studentsName = name;
        this.studentSurname = surname;
		this.studentsAge = age;
        this.studentsGroup = group;
	}

    public static void main(String[] args) {}

	@Override
    public int hashCode() {
       final int prime = 31;
       return prime + Objects.hash(this.studentsName, this.studentsAge, this.studentsGroup);
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentsName != other.studentsName)
			return false;
		if (studentsAge != other.studentsAge)
			return false;
		if (studentsGroup != other.studentsGroup)
            return false;
		if (studentsGroup != other.studentsGroup)
            return false;
		return true;
	}
}
