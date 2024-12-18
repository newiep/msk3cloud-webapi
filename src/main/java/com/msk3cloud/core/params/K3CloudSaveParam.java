package com.msk3cloud.core.params;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kingdee.bos.webapi.entity.SaveParam;
import com.msk3cloud.config.LocalDateTimeSerializer;

import java.time.LocalDateTime;

/**
 * desc: 扩展保存参数
 *
 * @author Rao
 * @Date 2022/02/17
 **/
public class K3CloudSaveParam<T> extends SaveParam<T> {

    /**
     * 自动提交和审核
     */
    @SerializedName("IsAutoSubmitAndAudit")
    private Boolean isAutoSubmitAndAudit;

    public K3CloudSaveParam(T data) {
        super(data);
    }

    public void setAutoSubmitAndAudit(Boolean autoSubmitAndAudit) {
        isAutoSubmitAndAudit = autoSubmitAndAudit;
    }

    public Boolean getAutoSubmitAndAudit() {
        return isAutoSubmitAndAudit;
    }

    /**
     * 自定义 gson 序列化
     * @return 序列化后的json字符串
     */
    @Override
    public String toJson() {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        Expose expose = f.getAnnotation(Expose.class);
                        return expose != null && !expose.serialize();
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .create();
        return gson.toJson(this);
    }
}
