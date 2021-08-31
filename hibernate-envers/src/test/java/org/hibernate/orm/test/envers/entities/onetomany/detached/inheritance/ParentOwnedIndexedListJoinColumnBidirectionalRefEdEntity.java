/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.orm.test.envers.entities.onetomany.detached.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.orm.test.envers.integration.onetomany.detached.InheritanceIndexedJoinColumnBidirectionalList;

/**
 * Entity for {@link InheritanceIndexedJoinColumnBidirectionalList} test.
 * Owned side of the relation.
 *
 * @author Adam Warski (adam at warski dot org)
 */
@Entity
@Table(name = "ParOwnedIdxJoinColBiRefEd")
@Audited
public class ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity {
	@Id
	@GeneratedValue
	private Integer id;

	private String data;

	@Column(name = "indexed_index", insertable = false, updatable = false)
	private Integer position;

	@ManyToOne
	@JoinColumn(name = "indexed_join_column", insertable = false, updatable = false)
	private ParentIndexedListJoinColumnBidirectionalRefIngEntity owner;

	public ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity() {
	}

	public ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity(
			Integer id,
			String data,
			ParentIndexedListJoinColumnBidirectionalRefIngEntity owner) {
		this.id = id;
		this.data = data;
		this.owner = owner;
	}

	public ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity(
			String data,
			ParentIndexedListJoinColumnBidirectionalRefIngEntity owner) {
		this.data = data;
		this.owner = owner;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ParentIndexedListJoinColumnBidirectionalRefIngEntity getOwner() {
		return owner;
	}

	public void setOwner(ParentIndexedListJoinColumnBidirectionalRefIngEntity owner) {
		this.owner = owner;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( !(o instanceof ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity) ) {
			return false;
		}

		ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity that = (ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity) o;

		if ( data != null ? !data.equals( that.data ) : that.data != null ) {
			return false;
		}
		//noinspection RedundantIfStatement
		if ( id != null ? !id.equals( that.id ) : that.id != null ) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int result;
		result = (id != null ? id.hashCode() : 0);
		result = 31 * result + (data != null ? data.hashCode() : 0);
		return result;
	}

	public String toString() {
		return "ParentOwnedIndexedListJoinColumnBidirectionalRefEdEntity(id = " + id + ", data = " + data + ")";
	}
}