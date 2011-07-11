/*
 * WSEntityManager.java
 * 
 * Created on Sep 8, 2007, 4:53:40 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.util;

import java.util.Map;

import constants.Constants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

import service.ParamStruct;
import service.ReturnStruct;
import service.ServiceAdapter;
import util.BeanUtil;
import util.DBClient;

/**
 *
 * @author Budoy Entokwa
 * This class will only be use for persistence web service
 * This will only have limited function
 */
public class WSPersistenceEntityManager implements EntityManager {

    WSDummyTransaction trans = new WSDummyTransaction();
    static WSPersistenceEntityManager entityManager;

    public static WSPersistenceEntityManager getInstance() {
        if (entityManager == null) {
            entityManager = new WSPersistenceEntityManager();
        }
        return entityManager;
    }

    public void persist(Object arg0) {
        ParamStruct param = new ParamStruct();
        param.setActionCommand(Constants.INSERT);
        param.setServiceName(Constants.PERSISTENCE_SERVICE);
        param.setData(arg0);
        ReturnStruct ret = ServiceAdapter.getInstance().call(param);
        try {
            IBean bean = (IBean) ret.getData();
            BeanUtil.copyBean(bean, (IBean) arg0);
        } catch (Exception e) {
        }
    }

    public <T> T merge(T arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(Object arg0) {
        ParamStruct param = new ParamStruct();
        param.setActionCommand(Constants.DELETE);
        param.setServiceName(Constants.PERSISTENCE_SERVICE);
        param.setData(arg0);
        ReturnStruct ret = ServiceAdapter.getInstance().call(param);
    }

    public <T> T find(Class<T> arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public <T> T getReference(Class<T> arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFlushMode(FlushModeType arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public FlushModeType getFlushMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void lock(Object arg0, LockModeType arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void refresh(Object arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean contains(Object arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query createQuery(String arg0) {
        WSQuery query = new WSQuery(arg0, Constants.SELECT);
        return query;
    }

    public Query createNamedQuery(String arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query createNativeQuery(String arg0) {
        WSQuery query = new WSQuery(arg0, Constants.SELECT);
        return query;
    }

    public Query createNativeQuery(String arg0, Class arg1) {
        WSQuery query = new WSQuery(arg0, Constants.SELECT);
        return query;
    }

    public Query createNativeQuery(String arg0, String arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void joinTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getDelegate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isOpen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public EntityTransaction getTransaction() {
        return trans;
    }

	public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void detach(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map<String, Object> arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public LockModeType getLockMode(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Metamodel getMetamodel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public void lock(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub
		
	}

	public void refresh(Object arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub
		
	}

	public void refresh(Object arg0, LockModeType arg1) {
		// TODO Auto-generated method stub
		
	}

	public void refresh(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub
		
	}

	public void setProperty(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
