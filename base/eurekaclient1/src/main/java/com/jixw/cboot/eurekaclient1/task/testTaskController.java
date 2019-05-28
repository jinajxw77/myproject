package com.jixw.cboot.eurekaclient1.task;

import com.jixw.cboot.eurekaclient1.thread.ThreadRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class testTaskController {
    //3.添加定时任务
    //@Scheduled(cron = "0/10 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        ExecutorService pool = Executors.newCachedThreadPool();
        //此处就是开始执行我们自己的统计计算方法
        for(int i=0;i<5;i++){
            List<String> midList = new ArrayList<String>();
            for(int j=1;j<3;j++){
                midList.add(i+"_"+j);
            }
            pool.submit(new ThreadRunner(midList));
        }

        //下方是停止线程池的方法
        int awaitTime = 10;
        pool.shutdown();    //禁用提交的新任务,并且会等待时间所有的线程完毕自动停止
        try {
            if (!pool.awaitTermination(awaitTime, TimeUnit.SECONDS)) {
                System.out.println("时间到停止所有线程");
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();                     //（重新）取消当前线程是否中断
            Thread.currentThread().interrupt();     //保持中断状态
        }
    }
}
