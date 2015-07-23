package pl.spring.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.repository.LibraryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {

    @Autowired
    private LibraryDao libraryDao;
    @Autowired
    private LibraryRepository repo;
    @Autowired
    private BookDao bookDao;

    @Test
    public void testShouldFindBookById1() {
        // given
        final long libraryId = 1;
        // when
        LibraryEntity libraryEntity = libraryDao.findOne(libraryId);
        // then
        assertNotNull(libraryEntity);
        assertEquals("Pierwsza biblioteka", libraryEntity.getLibraryName());
    }
    
    @Test
    public void testShouldDeleteLibraryWithAllBooks() {
    	// given
    	final long libraryId = 1;
    	// when
//    	TransactionTemplate
    	libraryDao.delete(libraryId);
    	// then
    	assertNull(libraryDao.findOne(1L));
    	assertNull(bookDao.findOne(1L));
    	assertNull(bookDao.findOne(6L));
    }
    
    @Test
    public void testShouldFindBookById3() {
    	// given
    	final long libraryId = 3;
    	// when
    	LibraryEntity libraryEntity = libraryDao.findOne(libraryId);
    	// then
    	assertNotNull(libraryEntity);
    	assertEquals("Trzecia biblioteka", libraryEntity.getLibraryName());
    }

    @Test
    public void testShouldFindByNameP() {
        // given
        final String libraryName = "p";
        // when
        List<LibraryEntity> libraryEntities = libraryDao.findByName(libraryName);
        // then
        assertNotNull(libraryEntities);
        assertFalse(libraryEntities.isEmpty());
        assertEquals("Pierwsza biblioteka", libraryEntities.get(0).getLibraryName());
    }
    
    @Test
    public void testShouldFindByNameBibl() {
    	// given
    	final String libraryName = "bibl";
    	// when
    	List<LibraryEntity> libraryEntities = libraryDao.findByName(libraryName);
    	// then
    	assertNotNull(libraryEntities);
    	assertFalse(libraryEntities.isEmpty());
    	assertEquals("Biblioteka Mikołaj", libraryEntities.get(0).getLibraryName());
    }
}
