package uebung2.test;
import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ContainerTest {
    private Container container;
    private ConcreteMember member1;
    private ConcreteMember member2;

    @BeforeEach
    void setUp() {
        container = new Container();
        member1 = new ConcreteMember(1);
        member2 = new ConcreteMember(2);
    }

    @Test
    void posTestInitialState() {
        Container container_test = new Container();
        Assertions.assertEquals(0, container_test.size());
    }

    @Test
    void posAddMemberTest() throws ContainerException {
        container.addMember(member1);
        Assertions.assertEquals(1, container.size());
        container.addMember(member2);
        Assertions.assertEquals(2, container.size());
    }

    @Test
    void negAddMemberTest() throws ContainerException {
        member1 = new ConcreteMember(1);
        member2 = new ConcreteMember(1);

        try {
            container.addMember(member1);
            container.addMember(member2); // This should throw an exception
        } catch (ContainerException e) {
            // Check if the exception message is as expected
            Assertions.assertEquals("Das Member-Objekt mit der ID 1 ist bereits vorhanden!", e.getMessage());
        }
    }

    @Test
    void posDeleteMemberTest() throws ContainerException {
        container.addMember(member1);
        Assertions.assertEquals(1, container.size());
        container.addMember(member2);
        Assertions.assertEquals(2, container.size());
        container.deleteMember(1);
        Assertions.assertEquals(1, container.size());
        container.deleteMember(2);
        Assertions.assertEquals(0, container.size());
    }

    @Test
    void negDeleteMemberTest() throws ContainerException {
        container.addMember(member1);
        Assertions.assertEquals(1, container.size());
        container.addMember(member2);
        Assertions.assertEquals(2, container.size());
        String result = container.deleteMember(3);
        Assertions.assertEquals("Es existiert kein Member mit der ID: 3", result);
    }

    @Test
    void posSizeTest() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        int result = container.size();
        Assertions.assertEquals(2, result);
    }

    @Test
    void posDumpTest() throws ContainerException {
        container.addMember(member1);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        container.dump();
        String printedOutput = outputStream.toString().trim();
        String expectedOutput = "Member (ID = 1)";
        Assertions.assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void posAddNullTest() throws ContainerException {
        member2 = new ConcreteMember(0);
        container.addMember(member1);
        int result = container.size();
        Assertions.assertEquals(1, result);
    }



}
