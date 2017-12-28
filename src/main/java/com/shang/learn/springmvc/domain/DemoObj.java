package com.shang.learn.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoObj {
    private Long id;
    private String name;
    public DemoObj() {
        super();
    }
    public DemoObj(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }
}
