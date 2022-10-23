package apireq.storage.postgres;

import apireq.storage.relation.relation.Relation;

public class postgres implements Relation {

    public boolean SaveName(String name) {
        // logic buisness
        System.out.format("Save user in postgres - %s\n", name);
        return true;
    }
}
