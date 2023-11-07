package uebung3;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws23.uebung2.*;
import org.hbrs.se1.ws23.uebung3.persistence.*;


import org.junit.jupiter.api.Test;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;

public class ContainerPersistenceTest {
    Container container;
    PersistenceStrategy<Member> mongoDB;
    PersistenceStrategy<Member> stream;
    Member m1;

    @BeforeEach
    void setUp() {
        container = new SingletonContainer();
        stream = new PersistenceStrategyStream<>();
        mongoDB = new PersistenceStrategyMongoDB<>();
        m1 = new ConcreteMember(1);
    }
}
