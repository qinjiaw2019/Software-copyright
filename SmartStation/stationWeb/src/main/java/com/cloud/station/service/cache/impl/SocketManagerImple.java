package com.cloud.station.service.cache.impl;


import com.cloud.station.service.cache.SocketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.Socket;
import java.util.*;

@Service("socketManager")
public class SocketManagerImple implements SocketManager{
    private final Map<String, Socket> enties = new HashMap<>();
    private final String NAMESPACE = "socketManager";
    @Autowired
    private CacheManager cacheManager;


    @Override
    @CachePut(cacheNames = NAMESPACE)
    public void add(Socket socket) {
        enties.put(socket.getInetAddress().toString(), socket);
    }

    @Override
    @CacheEvict(cacheNames = NAMESPACE)
    public void delete(String key) {
         enties.remove(key);
    }

    @Override
    public void clear() {
        //TODO 清空所有的Socket连接未实现
    }

    @Override
    @Cacheable(cacheNames = NAMESPACE)
    public Socket get(String key) {
        return enties.get(key);
    }

    @Override
    @CachePut(cacheNames = NAMESPACE)
    public void update(Socket socket) {
        enties.put(socket.getInetAddress().toString(),socket);
    }

    @Override
    public Integer count() {
        return enties.size();
    }

    @Override
    @Cacheable(cacheNames = NAMESPACE)
    public List getOtherSocket(Socket socket) {
        List list = new ArrayList();
        String key = socket.getInetAddress().toString();

        Iterator iterator=enties.values().iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
