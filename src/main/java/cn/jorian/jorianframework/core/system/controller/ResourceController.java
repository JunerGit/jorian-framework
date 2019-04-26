package cn.jorian.jorianframework.core.system.controller;

import cn.jorian.jorianframework.common.response.ResponseCode;
import cn.jorian.jorianframework.common.response.SystemResponse;
import cn.jorian.jorianframework.core.system.dto.ResourceAddDTO;
import cn.jorian.jorianframework.core.system.dto.ResourceFindDTO;
import cn.jorian.jorianframework.core.system.entity.SysResource;
import cn.jorian.jorianframework.core.system.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: jorian
 * @Date: 2019/4/17 09:24
 * @Description:
 */
@RestController
@Api(tags = {"资源管理"})
@RequestMapping("system")
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @ApiOperation("新增资源")
    @RequestMapping(value="resource",method = RequestMethod.POST)
    public SystemResponse resourceAdd(@RequestBody @Validated @ApiParam(value = "资源基础信息")ResourceAddDTO resourceAddDTO){
        resourceService.add(resourceAddDTO);
        return new SystemResponse(ResponseCode.SUCCESS);
    }
    @ApiOperation("删除资源")
    @RequestMapping(value="resource/{id}",method = RequestMethod.DELETE)
    public SystemResponse resourceDelete(@PathVariable("id") @ApiParam(value = "资源id")String id){
        resourceService.delete(id);
        return new SystemResponse(ResponseCode.SUCCESS);
    }
    @ApiOperation("更新资源")
    @RequestMapping(value="resource",method = RequestMethod.PUT)
    public SystemResponse resourceUpdate(@RequestBody @Validated @ApiParam(value = "资源更新信息")SysResource sysResource){
        resourceService.update(sysResource);
        return new SystemResponse(ResponseCode.SUCCESS);
    }
    @ApiOperation("资源列表查询")
    @RequestMapping(value="resource/list",method = RequestMethod.GET)
    public SystemResponse resourceList(ResourceFindDTO resourceFindDTO){
        return new SystemResponse(ResponseCode.SUCCESS, resourceService.getList(resourceFindDTO));
    }
    @ApiOperation("资源树查询")
    @RequestMapping(value="resource/tree",method = RequestMethod.GET)
    public SystemResponse resourceTree(){
        return new SystemResponse(ResponseCode.SUCCESS,resourceService.getTree());
    }


}
