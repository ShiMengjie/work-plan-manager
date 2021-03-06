package com.shimengjie.wpm.work.port.adapter.persistence.repository;

import com.shimengjie.wpm.common.utils.CollectionUtil;
import com.shimengjie.wpm.common.utils.StringUtil;
import com.shimengjie.wpm.work.domain.model.activity.ActivityWork;
import com.shimengjie.wpm.work.domain.model.activity.ActivityWorkRepository;
import com.shimengjie.wpm.work.port.adapter.persistence.repository.mapper.ActivityWorkMapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author shimengjie
 * @date 2021/9/22 17:29
 **/
@Component
public class MybatisActivityWorkRepository implements ActivityWorkRepository {

    @Resource
    private ActivityWorkMapper activityWorkMapper;

    /**
     * 根据标题查询活动作品ID列表
     *
     * @param title 标题
     * @return List<Long>
     */
    @Override
    public List<Long> queryActivityWorkIdListByTitle(String title) {
        if (StringUtil.isBlank(title)) {
            return activityWorkMapper.queryActivityWorkIds();
        } else {
            return activityWorkMapper.queryActivityWorkIdsByTitle(title);
        }
    }

    @Override
    public List<ActivityWork> queryActivityWorkListByIds(Collection<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return new ArrayList<>(1);
        }
        Example example = new Example(ActivityWork.class);
        example.createCriteria().andIn("id", ids);
        return activityWorkMapper.selectByExample(example);
    }

}
