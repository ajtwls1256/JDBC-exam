package game.main.controller;

import java.sql.Connection;

import common.JDBCTemplate;
import game.main.dao.MainDao;
import game.main.model.Member;
import game.main.view.MainView;

public class MainController {
   MainDao d = new MainDao();
   MainView mv = new MainView();
   
   public void newMem(String selId) {
      Connection conn = JDBCTemplate.getConnection();
      Member m = d.selId(conn, selId); 
      if(m!=null) {
         mv.print("이미 존재하는 id");
         return;
      }
      m = mv.newMem(selId);
      if(d.newMem(conn, m)>0) {
         JDBCTemplate.commit(conn);
         mv.print("가입에 성공!");
      } else {
         JDBCTemplate.rollback(conn);
         mv.print("가입에 실패 ㅠㅠ ");
      }
      JDBCTemplate.close(conn);
   }

   public void start(Member m) {
      Connection conn = JDBCTemplate.getConnection();
      Member mm = d.checkId(conn, m); 
      if(mm==null) {
         mv.print("ID가 없습니다");
         JDBCTemplate.close(conn);
         return;
      }else if(mm.getNickName() == null){
         mv.print("PWD가 다릅니다!");
         JDBCTemplate.close(conn);
         return;
      }else {
         JDBCTemplate.close(conn);
         System.out.println(mm.getNickName()+"님 환영합니다!");
         mv.gameList();
      }
   }
   
}