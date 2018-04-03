/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.dtos;

public class EventDTO {

    String id, userPost, title, startDate, endDate, min, max, category, description, image, status, reason;

    public EventDTO() {
    }

    public EventDTO(String id, String userPost, String title, String startDate, String endDate, String status) {
        this.id = id;
        this.userPost = userPost;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public EventDTO(String id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public EventDTO(String id, String userPost, String title, String startDate, String endDate, String min, String max, String category, String description, String image, String status, String reason) {
        this.id = id;
        this.userPost = userPost;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.min = min;
        this.max = max;
        this.category = category;
        this.description = description;
        this.image = image;
        this.status = status;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "EventDTO{" + "id=" + id + ", userPost=" + userPost + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", min=" + min + ", max=" + max + ", category=" + category + ", description=" + description + ", image=" + image + ", status=" + status + ", reason=" + reason + '}';
    }

}
