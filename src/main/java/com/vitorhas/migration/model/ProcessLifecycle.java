package com.vitorhas.migration.model;

import lombok.Data;

public enum ProcessLifecycle {

    PENDING(0), PROCESSING(1), SUCCESS(2), FAILED(3), RESTART(4);

    private int idLifecycle;

    private ProcessLifecycle(int idLifecycle){
        this.idLifecycle = idLifecycle;
    }
}
