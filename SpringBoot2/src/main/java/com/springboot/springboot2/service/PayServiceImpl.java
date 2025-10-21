package com.springboot.springboot2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.springboot2.mapper.PayMapper;
import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.PayInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * 支付信息服务实现类
 * 实现分页按条件查询支付信息
 */
@Service
public class PayServiceImpl implements PayService {

    private final PayMapper payMapper;

    // ✅ 推荐使用构造注入（比 @Autowired 字段注入更安全、易测试）
    public PayServiceImpl(PayMapper payMapper) {
        this.payMapper = payMapper;
    }

    /**
     * 支付信息分页查询接口实现
     *
     * @param current    当前页码
     * @param size       每页数量
     * @param start      开始日期
     * @param end        结束日期
     * @param username   用户姓名（模糊匹配）
     * @param idCard     身份证号
     * @param floorId    楼层ID
     * @param buildingId 建筑ID
     * @return 分页结果 PageResult<PayInfo>
     */
    @Override
    public PageResult<PayInfo> pageOfPayInfo(Integer current,
                                             Integer size,
                                             LocalDate start,
                                             LocalDate end,
                                             String username,
                                             String idCard,
                                             Integer floorId,
                                             Integer buildingId) {

        // ✅ 1. 参数校验（防止前端传入非法页码或页大小）
        current = (current == null || current < 1) ? 1 : current;
        size = (size == null || size < 1 || size > 100) ? 10 : size;

        // ✅ 2. 创建分页对象
        Page<PayInfo> page = new Page<>(current, size);

        // ✅ 3. 调用 Mapper 查询（MyBatis-Plus 自动分页）
        Page<PayInfo> resultPage = payMapper.selectPayInfoOnCondition(
                page, start, end, username, idCard, floorId, buildingId
        );

        // ✅ 4. 封装结果返回（统一分页返回结构）
        return new PageResult<PayInfo>(
                resultPage.getRecords(),
                resultPage.getTotal(),
                (int) resultPage.getCurrent(),
                (int) resultPage.getSize()
        );
    }
}
