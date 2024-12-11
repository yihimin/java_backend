package idusw.javaweb.bapi202312407.repository;

import idusw.javaweb.bapi202312407.model.Member;
import java.util.List;

//crud: create read update delete
//http method: post, get, put, delete
public interface MemberDAO {
    int create(Member member);
    Member read(Member member);
    List<Member> readList();
    int update(Member member);
    int delete(Member member);

    /*
    Member readByEmail(Member member);

    List<Member> readListPagination(Pagination pagination);
    int readTotalRows();

    List<Member> sortListPaginationDN(Pagination pagination);
    List<Member> sortListPaginationAN(Pagination pagination);
    List<Member> sortListPaginationDE(Pagination pagination);
    List<Member> sortListPaginationAE(Pagination pagination);
     */
}