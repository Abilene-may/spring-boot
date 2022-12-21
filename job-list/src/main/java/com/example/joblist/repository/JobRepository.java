package com.example.joblist.repository;

import com.example.joblist.constant.Location;
import com.example.joblist.entity.Job;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class JobRepository {
    private List<Job> jobList = new ArrayList<>();
    public JobRepository(){
        jobList.add( new Job("a-1", "TTS Java", "Tuyen dung thuc tap sinh Java",
                Location.HA_NOI, 300, 700, "tdung@gmail.com"));
        jobList.add( new Job("a-2", "Tuyen dung Sale", "Tuyen dung vi tri nhan viên kinh doanh",
                Location.HAI_PHONG, 350, 800, "tdungsale@gmail.com"));
        jobList.add( new Job("a-3", "Tuyen dung FE", "Tuyen dung 5 vi tri FE",
                Location.DA_NANG, 300, 700, "tdungfe@gmail.com"));
        jobList.add( new Job("a-4", "Tuyen dung Tester", "Tuyen dung vi tri Tester",
                Location.HA_NOI, 260, 670, "tdungtester@gmail.com"));
        jobList.add( new Job("a-5", "Tuyen dung Java", "Tuyen dung lap trinh viên Java",
                Location.HO_CHI_MINH, 600, 1200, "tdungjava@gmail.com"));

    }
}
