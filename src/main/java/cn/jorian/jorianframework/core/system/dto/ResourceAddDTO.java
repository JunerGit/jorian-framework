package cn.jorian.jorianframework.core.system.dto;

import cn.jorian.jorianframework.core.system.entity.SysRole;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Auther: jorian
 * @Date: 2019/4/18 15:35
 * @Description:
 */
@Data
public class ResourceAddDTO {
    @NotBlank(message = "父级不能为空")
    private String pid;

    @NotBlank(message = "资源名不能为空")
    private String name;

    private String icon;

    @NotBlank(message = "资源路由不能为空")
    private String url;

    private Integer type;

    @NotBlank(message = "权限表达式不能为空")
    private String permission;

    private Integer sort;

    private Boolean isVerify;
}
