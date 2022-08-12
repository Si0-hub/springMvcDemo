package com.springMvc.demo.controller;

import com.springMvc.demo.entity.Productlist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/productlist")
public class ProductlistController {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productlist.class).buildSessionFactory();

    @RequestMapping("add")
    public String add() {
        return "insert";
    }

    @RequestMapping("/addSave")
    public String create(@RequestParam String title, @RequestParam String releasedate, @RequestParam String deadlinedate,
                         @RequestParam String announcer, @RequestParam String announcement) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Productlist data = new Productlist(title, releasedate, deadlinedate, announcer, announcement);
            session.save(data);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }

        return "redirect:read";
    }

    @RequestMapping("/read")
    public String read(Model model) {

        Session session = sessionFactory.getCurrentSession();
        List<Productlist> productlist = new LinkedList<Productlist>();

        try {
            session.beginTransaction();
            productlist = session.createQuery("from Productlist").list();
            session.getTransaction().commit();
            model.addAttribute("productlists", productlist);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }

        return "read";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("pkno") Integer pkno) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Productlist productlist = session.get(Productlist.class, pkno);
            session.delete(productlist);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return "redirect:read";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam Integer pkno, Model model) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Productlist productlist = session.get(Productlist.class, pkno);
            session.getTransaction().commit();
            model.addAttribute("productlist", productlist);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }

        return "edit";
    }

    @RequestMapping("/editSave")
    public String editSave(@RequestParam Integer pkno, @RequestParam String title, @RequestParam String releasedate, @RequestParam String deadlinedate,
                           @RequestParam String announcer, @RequestParam String announcement) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Productlist productlist = session.get(Productlist.class, pkno);
            // 更新
            productlist.setTitle(title);
            productlist.setReleasedate(releasedate);
            productlist.setDeadlinedate(deadlinedate);
            productlist.setAnnouncer(announcer);
            productlist.setAnnouncement(announcement);
            session.update(productlist);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }

        return "redirect:read";
    }
}
