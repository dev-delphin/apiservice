package apireq.storage;

import apireq.storage.relation.relation;

public class storage {
    // No realization object
    relation.Relation StorageUnit;

    // Constructor
    public storage(relation.Relation su) {
        // Injection
        StorageUnit = su;
    }

    public boolean SaveUserName(String name) {
        return this.StorageUnit.SaveName(name);
    }
}
