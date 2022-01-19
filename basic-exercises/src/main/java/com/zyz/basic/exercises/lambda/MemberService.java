package com.zyz.basic.exercises.lambda;

import com.zyz.basic.exercises.entity.Member;

/**
 * 成员服务类
 *
 * @author 张易筑
 * @date 2022/1/19-13:35 星期三
 */
@FunctionalInterface
public interface MemberService {

    /**
     * 添加成员信息
     *
     * @param memberId 成员ID
     * @param memberName 成员名
     * @return {@link Member} 成员
     * @author 张易筑
     * @date 2022-01-19 13:38:24
     */
    Member addMember(Long memberId, String memberName);

    /**
     * 获取成员
     *
     * @author 张易筑
     * @date 2022-01-19 14:58:37
     */
    default void getMember() {
        System.out.println("I am member");
    }
}
