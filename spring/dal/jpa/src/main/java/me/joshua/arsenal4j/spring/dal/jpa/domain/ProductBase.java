/**
 *    Copyright 2010-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package me.joshua.arsenal4j.spring.dal.jpa.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import me.joshua.arsenal4j.spring.dal.jpa.commons.ProductTypeConverter;

@MappedSuperclass
public class ProductBase extends BaseModel {

	private static final long serialVersionUID = -7492639752670189553L;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(name = "descn")
	private String description;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "front", column = @Column(name = "front") ),
			@AttributeOverride(name = "back", column = @Column(name = "back") ) })
	private ProductImages images;

	@Convert(converter = ProductTypeConverter.class)
	private ProductType type;

	public ProductBase() {
	}

	public ProductBase(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.version = 0L;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductImages getImages() {
		return images;
	}

	public void setImages(ProductImages images) {
		this.images = images;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

}
