package com.grove.leetcode.app;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1125. 最小的必要团队
 */
@Component
public class App1125 {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillToInt = new HashMap<>();
        int allSkill = 0;
        // 技能位数映射表
        for (int i = 0; i < req_skills.length; i ++) {
            skillToInt.put(req_skills[i], 1 << i+1);
            allSkill |= (1<<i+1);
        }

        // 员工技能数映射表
        Map<Integer, Integer> personSkillToInt = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            List<String> skills = people.get(i);
            int personSkillSum = 0;
            for (String skill : skills) {
                personSkillSum |= Integer.parseInt(skill);
            }
            personSkillToInt.put(i, personSkillSum);
        }

        // 查出每一个技能对应的





        return null;
    }
}
