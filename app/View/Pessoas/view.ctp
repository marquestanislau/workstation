<div class="pessoas view">
<h2><?php echo __('Pessoa'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($pessoa['Pessoa']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($pessoa['Pessoa']['nome']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Apelido'); ?></dt>
		<dd>
			<?php echo h($pessoa['Pessoa']['apelido']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Data'); ?></dt>
		<dd>
			<?php echo h($pessoa['Pessoa']['data']); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Pessoa'), array('action' => 'edit', $pessoa['Pessoa']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Pessoa'), array('action' => 'delete', $pessoa['Pessoa']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $pessoa['Pessoa']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Pessoas'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Pessoa'), array('action' => 'add')); ?> </li>
	</ul>
</div>
