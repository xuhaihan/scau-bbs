package com.scau.bbs.common.base;


import com.scau.bbs.common.dto.QuarkResult;

@FunctionalInterface
public interface ResultProcessor {
    QuarkResult process();
}
