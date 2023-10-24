package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        for (Member m : members) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException(member.getID());
            }
        }
        members.add(member);
    }

    public String deleteMember(Integer id) {
        for (Member m : members) {
            if (m.getID().equals(id)) {
                members.remove(m);
                return "Member mit der ID " + id + " wurde erfolgreich entfernt.";
            }
        }
        return "Es existiert kein Member mit der ID: " + id;    //Statement: Es ist leichter unbeabsichtigte Fehler zu übersehen. Exceptions hingegen erzwingen es, auf Fehler zu reagieren
    }

    public void dump() {
        for (Member m : members) {
            System.out.println(m);
        }
    }

    public int size() {
        return members.size();
    }
}
