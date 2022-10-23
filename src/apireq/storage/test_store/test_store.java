package apireq.storage.test_store;

import apireq.storage.relation.relation.Relation;

public class test_store implements Relation {
    
    public boolean SaveName(String name) {
        // logic buisness
        System.out.format("Save user in test - %s\n", name);
        return true;
    }
}
