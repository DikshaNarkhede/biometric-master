package edu.cornell.cals.biomat.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.service.BioMaterialGroupingService;
import edu.cornell.cals.biomat.service.BioMaterialService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BioMaterialServiceImplTest {

		@Autowired
		BioMaterialService bioMaterialService;
		
		@Autowired	
		BioMaterialGroupingService bioMaterialGroupingService;
		
		@Test
		public void getBioMaterial() {
			Long id = 5000l;
			BioMaterial bm =bioMaterialService.getBioMaterial(id);
			assertThat( bm.getId()).isEqualTo(id);
			assertThat( bm.getShortDesc()).startsWith("CHICKEN");
			
		}
		
		@Test
	    public void getBioMaterialWithFormula(){
			List<BioMaterial> bmList = bioMaterialService.getBioMaterialWithFormula("c%");
			assertThat( bmList.size()>0);
		}
		
		@Test
		public void delete() {
			boolean flag = bioMaterialGroupingService.removeGroupUsingId(1100L);
			assertThat(flag == true);
		}

}
