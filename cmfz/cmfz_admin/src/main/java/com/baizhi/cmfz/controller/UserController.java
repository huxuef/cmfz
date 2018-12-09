package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.dao.UserDAO;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.entity.UserLocation;
import com.baizhi.cmfz.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 查所有
    @RequestMapping("/showAllUser")
    public List<User> showAllUser(){
        List<User> users = userService.queryAll();
        return users;
    }

    // 全部导出
    @RequestMapping("/exportAll")
    public Map<String,Object> exportAll() throws Exception {
        Map<String,Object> map =new HashMap<String, Object>();
        try{
            List<User> users = userService.queryAll();
            //1. 创建Excel对象
            // .xls  HSSFWorkbook
            // .xlsx XSSFWorkbook
            Workbook workbook = new HSSFWorkbook();

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));

            //2. 创建工作页对象
            Sheet sheet = workbook.createSheet("用户信息");

            //3. 创建行对象
            Row row = sheet.createRow(0);
            String[] titles = {"用户编号","姓名","昵称","密码","私盐","电话","性别","个性签名","头像","状态","城市","创建时间"};

            for (int i = 0; i < titles.length; i++) {
                //4. 创建单元格对象
                Cell cell = row.createCell(i);
                cell.setCellValue(titles[i]);
            }
            // 遍历用户信息
            for (int i = 0; i< users.size(); i++) {
                row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(users.get(i).getId());
                row.createCell(1).setCellValue(users.get(i).getName());
                row.createCell(2).setCellValue(users.get(i).getNickName());
                row.createCell(3).setCellValue(users.get(i).getPassword());
                row.createCell(4).setCellValue(users.get(i).getSalt());
                row.createCell(5).setCellValue(users.get(i).getPhone());
                row.createCell(6).setCellValue(users.get(i).getSex());
                row.createCell(7).setCellValue(users.get(i).getSignature());
                row.createCell(8).setCellValue(users.get(i).getImg());
                row.createCell(9).setCellValue(users.get(i).getStatus());
                row.createCell(10).setCellValue(users.get(i).getLocation());
                row.createCell(11).setCellValue(users.get(i).getCreateDate());
            }
            //5. 创建Excel文件
            workbook.write(new FileOutputStream("E:\\test.xls"));
            map.put("message","导出成功");
        }catch(Exception e){
            e.printStackTrace();
            map.put("message","导出失败");
        }
        return map;

    }


    // 自定义导出
    @RequestMapping("/selfDefindExport")
    public Map<String,Object> selfDefindExport(String columns, String titles, HttpServletResponse response) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Map<String,Object> map =new HashMap<String, Object>();
        try {
            List<User> users = userService.queryCondition(columns);
            // 新建excel
            Workbook workbook = new HSSFWorkbook();
            // 设置日期格式
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("yyyy-MM-dd"));
            // 创建工作页
            Sheet sheet = workbook.createSheet("用户信息");
            // 创建行对象
            Row row = sheet.createRow(0);

            // 将用户信息导出到Excel中
            // 先将标题导入Excel
            String[] title = titles.split(",");
            for (int i = 0; i < title.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(title[i]);
            }
            // 导入数据
            String[] column = columns.split(",");
            for (int i = 1; i <= users.size(); i++) {
                row = sheet.createRow(i);
                User user = users.get(i - 1);
                Class<? extends User> c = user.getClass();
                for (int j = 0; j < column.length; j++) {
                    Cell cell = row.createCell(j);
                    // id---> Id

                    // 拆分user_id
                    String[] cName = column[j].split("_");
                    String getMethodName = "get";
                    if(cName.length==1){  // 没有_拼接
                        getMethodName += cName[0].substring(0,1).toUpperCase()+cName[0].substring(1,cName[0].length());
                    }else{  // 有_拼接
                        for (int k = 0; k < cName.length; k++) {
                            getMethodName += cName[k].substring(0,1).toUpperCase()+cName[k].substring(1,cName[k].length());
                        }
                    }
                    Method method = c.getMethod(getMethodName, null);
                    Object obj = method.invoke(user, null);
                    if (obj == null) {
                        continue;
                    }
                    if (obj instanceof Date) {
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) obj);
                    } else {
                        cell.setCellValue(obj.toString());
                    }
                }
            }
            response.setHeader("content-disposition", "attachment;filename=user.xls");
            response.setContentType("application/vnd.ms-excel");
            ((HSSFWorkbook) workbook).write(response.getOutputStream());
            map.put("message","导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","导出失败");
        }
        return map;

    }



    // 导入
    @RequestMapping("/importAll")
    public Map<String,Object> importAll() throws Exception {
        Map<String,Object> map =new HashMap<String, Object>();
        try{
            Workbook workbook = new XSSFWorkbook(new FileInputStream("E:\\test3.xlsx"));
            Sheet sheet = workbook.getSheet("学生信息");
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                User user = new User();
                Row row = sheet.getRow(i);
                for (int j = 0; j <= row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        if (j == 0) {
                            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                            user.setId(row.getCell(0).getStringCellValue());
                        }
                        if (j == 1) {
                            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                            user.setName(row.getCell(1).getStringCellValue());
                        }
                        if (j == 2) {
                            Cell cell1 = row.getCell(2);
                            user.setNickName(cell1.getStringCellValue());
                        }
                        if (j == 3) {
                            Cell cell1 = row.getCell(3);
                            user.setPassword(cell1.getStringCellValue());
                        }
                        if (j == 4) {
                            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                            user.setSalt(row.getCell(4).getStringCellValue());
                        }
                        if (j == 5) {
                            row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                            user.setPhone(row.getCell(5).getStringCellValue());
                        }
                        if (j == 6) {
                            Cell cell1 = row.getCell(6);
                            user.setSex(cell1.getStringCellValue());
                        }
                        if (j == 7) {
                            Cell cell1 = row.getCell(7);
                            user.setSignature(cell1.getStringCellValue());
                        }
                        if (j == 8) {
                            Cell cell1 = row.getCell(8);
                            user.setImg(cell1.getStringCellValue());
                        }
                        if (j == 9) {
                            Cell cell1 = row.getCell(9);
                            user.setStatus(cell1.getStringCellValue());
                        }
                        if (j == 10) {
                            row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
                            user.setLocation(row.getCell(10).getStringCellValue());
                        }
                        if (j == 11) {
                            if (cell.getCellType() == 0) {
                                Cell cell1 = row.getCell(11);
                                user.setCreateDate(cell1.getDateCellValue());
                            }
                        }
                    }
                    System.out.println();
                }
                userService.addUser(user);
            }
            map.put("message","导入成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","导入失败");
        }
        return map;
    }

    // 统计分析
    @RequestMapping("/statisticsManager")
    public Map<String,Object> statisticsManager(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(7);
        list.add(15);
        list.add(30);
        list.add(90);
        list.add(180);
        list.add(365);
        map.put("xAxisData",list);
        List<Integer> list1 = new ArrayList<Integer>();
        for (Integer integer : list) {
            Integer count = userService.queryCount(integer);
            list1.add(count);
        }
        map.put("yAxisData",list1);
        return map;
    }

    // 用户在各个地区的人数  Distribution:分布
    @RequestMapping("/userDistribution")
    public List<UserLocation> userDistribution(String sex){
        List<UserLocation> list = userService.queryLocationCount(sex);
        return list;
    }

}
