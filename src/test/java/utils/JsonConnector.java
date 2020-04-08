package utils;

import Model.Student;
import TestData.Data;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonConnector {
    /**
     * @param file
     * Method read configuration data from json file.
     * @return Data object
     * @throws JsonParseException
     * @throws IOException
     */
    public static Data readData(File file) throws JsonParseException, IOException {
        try {
            Gson parser = new Gson();
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            Data data = parser.fromJson(buffer, Data.class);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method fills student data from json file
     * @param file
     * @return Student object
     * @throws JsonParseException
     * @throws IOException
     */
    public static Student fillStudentData(File file) throws JsonParseException, IOException {
        try {
            Gson parser = new Gson();
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            Student student = parser.fromJson(buffer, Student.class);
            return student;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String jsonSerializerStudent(Student student) {
        Gson gson = new Gson();
        return gson.toJson(student);
    }
}
