package itc.hoseo.springproject.repository;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Subscription;

import java.util.List;

public interface SubscriptRepository {
    public int setSubscript(int hostNo, int subscriberNO);
    public int delSubscript(int hostNo, int subscriberNO);
    public boolean checkSubscript(int hostNo, int subscriberNO);
    public List<Subscription> findSubscriptListById(String id);
}
