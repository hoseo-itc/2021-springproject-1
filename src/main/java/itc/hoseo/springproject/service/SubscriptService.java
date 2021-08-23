package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Subscription;
import itc.hoseo.springproject.repository.SubscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptService {
    @Autowired
    SubscriptRepository subscriptRepository;

    public boolean setSubscript(int hostNo,int subscriberNO){
        if(subscriptRepository.setSubscript(hostNo,subscriberNO)>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean delSubscript(int hostNo,int subscriberNO){
        if(subscriptRepository.delSubscript(hostNo,subscriberNO)>0){
            return true;
        }else{
            return false;
        }
    }

    public List<Subscription> findSubscriptListById(String id){
        return subscriptRepository.findSubscriptListById(id);
    }

    public boolean checkSubscript(int hostNo,int subscriberNO){
        return subscriptRepository.checkSubscript(hostNo,subscriberNO);
    }

}
