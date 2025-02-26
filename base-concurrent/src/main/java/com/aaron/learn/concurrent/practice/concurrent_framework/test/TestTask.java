package com.aaron.learn.concurrent.practice.concurrent_framework.test;

import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.processer.TaskProcesser;
import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.task.TaskResult;
import com.ytt.springcoredemo.concurrent.util.SleepUtil;

import java.util.Random;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:52 2019/8/30
 * @Modiflid By:
 */
public class TestTask implements TaskProcesser<Integer,Integer> {
    @Override
    public TaskResult<Integer> execute(Integer data) {

        Random random = new Random();

        int r = random.nextInt(500);

        SleepUtil.sleep(r);

        if(r < 300){
            return TaskResult.getSuccess(r + data);
        }else if (r>400){
            return TaskResult.getFailure(-1,"");
        }else {
            if(r > 350){
                return TaskResult.getException(-1,"",new Exception("异常"));
            }
            throw new RuntimeException("e: " + r);
        }

    }
}
