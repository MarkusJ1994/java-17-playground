package records;

import app.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = Application.class)
@JsonTest
class StudentTest {

    @Autowired
    private JacksonTester<Student> studentJson;
    @Autowired
    private JacksonTester<RecordStudent> recordStudentJson;

    @Test
    public void testStudentCreationAndAccess() {
        Student student = new Student("Bobby Tables", 15);
        assertEquals("Bobby Tables", student.getName());
        assertEquals(15, student.getAge());
    }

    @Test
    public void testRecordStudentCreationAndAccess() {
        RecordStudent student = new RecordStudent("Bobby Tables", 15);
        assertEquals("Bobby Tables", student.name());
        assertEquals(15, student.age());
    }

    @Test
    public void testToStringAndEquals() {
        RecordStudent recordStudent1 = new RecordStudent("Bobby Tables", 15);
        RecordStudent recordStudent2 = new RecordStudent("Bobby Tables", 15);

        assertEquals(recordStudent1.toString(), recordStudent2.toString());
        assertEquals(recordStudent1, recordStudent2);
    }

    @Test
    public void testJsonComparison() throws IOException {
        Student student = new Student("Bobby Tables", 15);
        RecordStudent recordStudent = new RecordStudent("Bobby Tables", 15);

        JsonContent<Student> studentJsonContent = studentJson.write(student);
        JsonContent<RecordStudent> recordStudentJsonContent = recordStudentJson.write(recordStudent);

        String studentJsonContentJson = studentJsonContent.getJson();
        String recordStudentJson = recordStudentJsonContent.getJson();

        assertEquals(studentJsonContentJson, recordStudentJson);
    }

}