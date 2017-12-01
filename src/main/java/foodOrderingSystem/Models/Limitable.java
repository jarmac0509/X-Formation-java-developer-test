package foodOrderingSystem.Models;

public interface Limitable {
  int getLimit();
  void increaseBoughtCount();
  int getBoughtCount();
}
