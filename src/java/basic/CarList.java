package basic;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class CarList {
    private List<Car> cars;

    public CarList() {
        cars=new ArrayList<>();
    }

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarList{" +
                "cars=" + cars +
                '}';
    }

    public int size() {
        return cars.size();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public boolean contains(Object o) {
        return cars.contains(o);
    }

    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public Object[] toArray() {
        return cars.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return cars.toArray(a);
    }

    public boolean add(Car car) {
        return cars.add(car);
    }

    public boolean remove(Object o) {
        return cars.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return cars.containsAll(c);
    }

    public boolean addAll(Collection<? extends Car> c) {
        return cars.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Car> c) {
        return cars.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return cars.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return cars.retainAll(c);
    }

    public void replaceAll(UnaryOperator<Car> operator) {
        cars.replaceAll(operator);
    }

    public void sort(Comparator<? super Car> c) {
        cars.sort(c);
    }

    public void clear() {
        cars.clear();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public Car set(int index, Car element) {
        return cars.set(index, element);
    }

    public void add(int index, Car element) {
        cars.add(index, element);
    }

    public Car remove(int index) {
        return cars.remove(index);
    }

    public int indexOf(Object o) {
        return cars.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return cars.lastIndexOf(o);
    }

    public ListIterator<Car> listIterator() {
        return cars.listIterator();
    }

    public ListIterator<Car> listIterator(int index) {
        return cars.listIterator(index);
    }

    public List<Car> subList(int fromIndex, int toIndex) {
        return cars.subList(fromIndex, toIndex);
    }

    public Spliterator<Car> spliterator() {
        return cars.spliterator();
    }

    public boolean removeIf(Predicate<? super Car> filter) {
        return cars.removeIf(filter);
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public Stream<Car> parallelStream() {
        return cars.parallelStream();
    }

    public void forEach(Consumer<? super Car> action) {
        cars.forEach(action);
    }
}
