package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  TorpedoStore single;
  TorpedoStore all;    

  @BeforeEach
  public void init(){
    this.single = mock(TorpedoStore.class);  
    this.all = mock(TorpedoStore.class);  
    this.ship = new GT4500(single, all);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(single.fire(1)).thenReturn(true); 
    when(single.isEmpty()).thenReturn(false); 
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(single.isEmpty()).thenReturn(false);
    when(single.getTorpedoCount()).thenReturn(10);
    when(single.fire(10)).thenReturn(true);   
    when(all.isEmpty()).thenReturn(false);
    when(all.getTorpedoCount()).thenReturn(10);
    when(all.fire(10)).thenReturn(true);  
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
